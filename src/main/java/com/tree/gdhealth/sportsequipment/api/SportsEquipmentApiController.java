package com.tree.gdhealth.sportsequipment.api;

import com.tree.gdhealth.vo.SportsEquipment;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**<p>sportEquipmet에 대한 apiController</p>
 * @author 정인호
 */
@Slf4j
@RequiredArgsConstructor
@RestController
public class SportsEquipmentApiController {
    private final ISportsEquipmentApiService service;
    @GetMapping("/api/v1/sportsEquipment")
    public List<SportsEquipment> getSportsEquipmentList(){

        return service.getSportsEquipmentList();
    }

    @GetMapping("/api/v1/sportsEquipment/{sportsEquipmentNo}")
    public SportsEquipment getSportsEquipmentOne(@PathVariable int sportsEquipmentNo){
        return service.getSportsEquipmentOne(sportsEquipmentNo);
    }
}
