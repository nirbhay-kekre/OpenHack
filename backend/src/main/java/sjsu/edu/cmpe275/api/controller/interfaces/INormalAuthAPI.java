package sjsu.edu.cmpe275.api.controller.interfaces;

import java.text.ParseException;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import sjsu.edu.cmpe275.api.resources.OrganizationRequest;
import sjsu.edu.cmpe275.api.resources.ProfileRequest;

public interface INormalAuthAPI {

	@RequestMapping(value = "/getProfile", produces = { MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET)
	public ResponseEntity<Object> getProfile(@RequestHeader(value = "Authorization") String token,
			@RequestParam(value = "email", required = true) String email);

	@RequestMapping(value = "/updateProfile", produces = {
			MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.POST)
	public ResponseEntity<Object> updateProfile(@RequestHeader(value = "Authorization") String token,
			@RequestBody ProfileRequest profileRequest);

	// Organizations

	@RequestMapping(value = "/searchOrganizations", produces = {
			MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET)
	public ResponseEntity<Object> searchOrganization(@RequestHeader(value = "Authorization") String token,
			@RequestParam(value = "name", required = true) String name);

	@RequestMapping(value = "/createOrganization", produces = {
			MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.POST)
	public ResponseEntity<Object> createOrganization(@RequestHeader(value = "Authorization") String token,
			@RequestBody OrganizationRequest organizationRequest);

	@RequestMapping(value = "/listRequestOrganization", produces = {
			MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET)
	public ResponseEntity<Object> listRequestOrganization(@RequestHeader(value = "Authorization") String token,
			@RequestParam(value = "email", required = true) String email);

	//hackathon
	
	@RequestMapping(value = "/listHackathon", produces = {
			MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET)
	public ResponseEntity<Object> listHackathon(@RequestHeader(value = "Authorization") String token,
			@RequestParam(value = "email", required = true) String email, 
			@RequestParam(value = "role", required = true) String role) throws ParseException;
	
	@RequestMapping(value = "/detailHackathon", produces = {
			MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET)
	public ResponseEntity<Object> detailHackathon(@RequestHeader(value = "Authorization") String token,
			@RequestParam(value = "email", required = true) String email, 
			@RequestParam(value = "role", required = true) String role,
			@RequestParam(value = "eventName", required = true) String eventName) throws ParseException;
	
	@RequestMapping(value = "/leaderBoard", produces = {
			MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET)
	public ResponseEntity<Object> leaderBoard(@RequestHeader(value = "Authorization") String token,
			@RequestParam(value = "eventName", required = true) String eventName) throws ParseException;
	
	
}
