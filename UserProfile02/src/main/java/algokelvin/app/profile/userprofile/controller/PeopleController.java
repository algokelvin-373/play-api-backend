package algokelvin.app.profile.userprofile.controller;

import algokelvin.app.profile.userprofile.config.GlobalApiResponse;
import algokelvin.app.profile.userprofile.services.PeopleServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Validated
@Api(tags = "Configuration")
@Slf4j
public class PeopleController {

    @Autowired
    private PeopleServices peopleServices;

    @GetMapping(value = "detail", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = GlobalApiResponse.class)
    }) public GlobalApiResponse<?> getDataProfile(@RequestParam int id) {
        return new GlobalApiResponse<>(
                HttpStatus.OK.value(),
                peopleServices.getProfile(id)
        );
    }

}
