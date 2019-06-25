package menondemand.jwtauthentication.controller;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import ibm.mentor.model.Mentor;
import ibm.mentor.model.SkillsTechnologiesEntity;
import ibm.mentor.model.User;
import menondemand.jwtauthentication.message.request.LoginForm;
import menondemand.jwtauthentication.message.request.MentorSignUp;
import menondemand.jwtauthentication.message.request.SignUpForm;
import menondemand.jwtauthentication.message.response.JwtResponse;
import menondemand.jwtauthentication.message.response.ResponseMessage;
import menondemand.jwtauthentication.model.Role;
import menondemand.jwtauthentication.model.RoleName;
import menondemand.jwtauthentication.repository.MentorRepository;
import menondemand.jwtauthentication.repository.RoleRepository;
import menondemand.jwtauthentication.repository.UserRepository;
import menondemand.jwtauthentication.security.jwt.JwtProvider;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/v1/api/auth")
public class AuthRestAPIs {

	@Autowired
	@Qualifier("edooka")
	public MailSender mailSender;
	
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;
		
	@Autowired
	MentorRepository mentorRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtProvider jwtProvider;

	@Autowired
	RestTemplate restTemplate;
	
	@Value("${skillrepo.url}")
	public String skillRepoUrl;
	
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String jwt = jwtProvider.generateJwtToken(authentication);
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		
		if(userRepository.findByUsernameAndActive(loginRequest.getUsername(), true).isPresent()) {
			return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername(), userDetails.getAuthorities()));
		} else {
			return new ResponseEntity<>(new ResponseMessage("User is pending email verification!"),
					HttpStatus.BAD_REQUEST);
		}		
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpForm signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return new ResponseEntity<>(new ResponseMessage("Fail -> Username is already taken!"),
					HttpStatus.BAD_REQUEST);
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return new ResponseEntity<>(new ResponseMessage("Fail -> Email is already in use!"),
					HttpStatus.BAD_REQUEST);
		}
		
		String confirmCode = randomAlphaNumeric(6);

		// Creating user's account
		User user = new User(signUpRequest.getName(), signUpRequest.getUsername(), signUpRequest.getEmail(),
				encoder.encode(signUpRequest.getPassword()), confirmCode);

		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();

		strRoles.forEach(role -> {
			switch (role) {
			case "admin":
				Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
				roles.add(adminRole);

				break;
			case "mentor":
				Role mentorRole = roleRepository.findByName(RoleName.ROLE_MENTOR)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
				roles.add(mentorRole);

				break;
			default:
				Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
				roles.add(userRole);
			}
		});

		user.setRoles(roles);
		userRepository.save(user);
		
		//send email with confirmation code in Hyper link
		String from = "mentorservice22@gmail.com";
		String to = signUpRequest.getEmail(); //get this email from db
		String subject = "Please Verify your Email";
		String body = "Click on link below to verify your account \n http://localhost:8080/v1/api/auth/user?ccode="+confirmCode+"&username="+signUpRequest.getUsername();
		
		mailSender.sendMail(from, to, subject, body);

		return new ResponseEntity<>(new ResponseMessage("User registered successfully!"), HttpStatus.OK);
	}
	
	@PostMapping("/mentor/signup")
	public ResponseEntity<?> registerMentor(@Valid @RequestBody MentorSignUp signUpRequest) {
		if (mentorRepository.existsByUsername(signUpRequest.getUsername())) {
			return new ResponseEntity<>(new ResponseMessage("Fail -> Username is already taken!"),
					HttpStatus.BAD_REQUEST);
		}

		// Creating new mentor
		Mentor mentor = new Mentor(signUpRequest.getUsername()
								, signUpRequest.getLinkedin()
								, signUpRequest.getYearsExp(),
								signUpRequest.getStartTime(),
								signUpRequest.getEndTime(),
								signUpRequest.getFee());

		Set<String> strSkills = signUpRequest.getSkills();
		Set<SkillsTechnologiesEntity> skills;
		

	    
	    skills = strSkills.stream().map(skill->{
			ResponseEntity<SkillsTechnologiesEntity> existingSkill = restTemplate.getForEntity(skillRepoUrl+"/v1/searchskill/"+skill, SkillsTechnologiesEntity.class);
			if(existingSkill.getBody()!=null) {
				return existingSkill.getBody();
			}else {
			    HttpEntity<SkillsTechnologiesEntity> request = new HttpEntity<>(new SkillsTechnologiesEntity(skill));
		    	return restTemplate.postForEntity(skillRepoUrl+"/v1/createskill", request, SkillsTechnologiesEntity.class).getBody();
			}
	    }).collect(Collectors.toSet());
	   
		mentor.setSkills(skills);
		mentorRepository.save(mentor);
		
		String confirmCode = randomAlphaNumeric(6);
		
		User user = new User(signUpRequest.getName(), signUpRequest.getUsername(), signUpRequest.getLinkedin(),
				encoder.encode(signUpRequest.getPassword()), confirmCode);
		Role mentorRole = roleRepository.findByName(RoleName.ROLE_MENTOR).get();
		Set<Role> roles = new HashSet<>();
		roles.add(mentorRole);
		user.setRoles(roles);
		
		userRepository.save(user);	
		
		String from = "mentorservice22@gmail.com";
		String to = signUpRequest.getLinkedin();
		String subject = "Please Verify your Email";
		String body = "Click on link below to verify your account \n http://localhost:8080/v1/api/auth/user?ccode="+confirmCode+"&username="+signUpRequest.getUsername();
		
		mailSender.sendMail(from, to, subject, body);
			
		return new ResponseEntity<>(new ResponseMessage("Mentor registered successfully!"), HttpStatus.OK);
	}
	
	@GetMapping("/user")
	public ResponseEntity<?> confirmSignup(@RequestParam("ccode") String ccode, @RequestParam("username") String username) {

		if(userRepository.findByUsernameAndConfirmCode(username, ccode).isPresent()) {
			
			User user = userRepository.findByUsername(username).get();
			user.setActive(true);
			userRepository.save(user);
			
			return new ResponseEntity<>(new ResponseMessage("User verification successful! You may now login"), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new ResponseMessage("Unable to Verify your account. Please contact System Administrator."), HttpStatus.OK);
		}
	}
	
	private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	
	public static String randomAlphaNumeric(int count) {
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
			builder.append(ALPHA_NUMERIC_STRING.charAt(character));
		}
		return builder.toString();
	}
	
}