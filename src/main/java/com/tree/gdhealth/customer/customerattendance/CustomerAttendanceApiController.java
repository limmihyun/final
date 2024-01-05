package com.tree.gdhealth.customer.customerattendance;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author 정인호
 */
@Slf4j
@RequiredArgsConstructor
@RestController
public class CustomerAttendanceApiController {
    private final CustomerAttendanceApiService service;

    @GetMapping("/api/v1/customerAttendance/{programDateNo}")
    public List<Map<String, Object>> getCustomerAttendanceList(@PathVariable int programDateNo, @RequestParam int branchNo){
        return service.getCustomerAttendanceList(programDateNo, branchNo);
    }

    @GetMapping("/api/v1/customerAttendance/enter")
    public void recordEnterTime(@RequestParam int programReservationNo){
        service.recordEnterTime(programReservationNo);
    }

    @GetMapping("/api/v1/customerAttendance/exit")
    public void recordExitTime(@RequestParam int programReservationNo){
        service.recordExitTime(programReservationNo);
    }
}
