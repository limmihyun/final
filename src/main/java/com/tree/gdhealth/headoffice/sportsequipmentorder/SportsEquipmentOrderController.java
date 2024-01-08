package com.tree.gdhealth.headoffice.sportsequipmentorder;

import com.tree.gdhealth.branch.sportsequipment.BranchSportsEquipmentService;
import com.tree.gdhealth.branch.sportsequipment.getOrderListResponseDto;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author 정인호
 */
@Slf4j
@RequiredArgsConstructor
@Controller
public class SportsEquipmentOrderController {
    final BranchSportsEquipmentService branchSportsEquipmentService;

    /**
     * @param requestPage 쿼리스트링의 요청페이지번호
     * @param isOnlyWaitingList 발주상태가 대기인 것만 추출할 것인지 여부
     * @apiNote {@link getOrderListResponseDto} 에 출력정보와 페이지네이션 정보가 함께 들어있습니다.
     */
    @GetMapping("/headoffice/sportsEquipmentOrder/list")
    public String getOrderList(
            @RequestParam(name = "requestPage", defaultValue = "1") int requestPage,
            @RequestParam(name = "isOnlyWaitingList", defaultValue = "false") boolean isOnlyWaitingList,
            @RequestParam(name = "branchNo", required = false) Integer branchNo,
            HttpServletRequest request, Model model) {

        getOrderListResponseDto orderListResponseDto = branchSportsEquipmentService.getOrderListResponseDto(
                branchNo,
                requestPage,
                isOnlyWaitingList);
        /*페이지네이션 URI 리스트 생성 시작*/
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.newInstance();
        uriComponentsBuilder.path("/headoffice/sportsEquipmentOrder/list")
                .queryParam("isOnlyWaitingList", isOnlyWaitingList)
                .queryParam("requestPage", requestPage)
                .queryParam("branchNo", branchNo);
        List<Map<String,Object>> paginationURIList = new ArrayList<>();
        for (int i = -4; i < 5; i++) {
            int page = requestPage + i;
            if ( page >= 1 && page <= orderListResponseDto.getLastPage()) {
                paginationURIList.add(Map.of("page",page, "URI",uriComponentsBuilder.replaceQueryParam("requestPage", page).build()));
            }
        }
        /*페이지네이션 URI 리스트 생성 종료*/
        orderListResponseDto.setPaginationURIList(paginationURIList);

        model.addAttribute("orderListResponseDto", orderListResponseDto);
        return "/headoffice/sportsEquipmentOrderList";
    }

    @GetMapping("/headoffice/sportsEquipmentOrderOne")
    public String getOrderOne(@RequestParam(name = "orderNo", required = false) Integer orderNo,
                              Model model){
        model.addAttribute("orderOne", branchSportsEquipmentService.getOrderOne(orderNo));
        return "/headoffice/sportsEquipmentOrderOne";
    }

    @PostMapping("/headoffice/sportsEquipmentOrderOne")
    public String changeOrderStatus(@RequestParam(name = "orderNo") Integer orderNo,
                                    @RequestParam(name = "changeOrderStatus") String changeOrderStatus){
            boolean isSuccess = branchSportsEquipmentService.changeOrderStatus(orderNo,changeOrderStatus);
        return "redirect:/headoffice/sportsEquipmentOrderOne?orderNo="+orderNo;

    }
}
