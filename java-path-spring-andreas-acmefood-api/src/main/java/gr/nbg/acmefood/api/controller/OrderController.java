package gr.nbg.acmefood.api.controller;

import gr.nbg.acmefood.api.domain.Order;
import gr.nbg.acmefood.api.mapper.BaseMapper;
import gr.nbg.acmefood.api.mapper.OrderMapper;
import gr.nbg.acmefood.api.service.BaseService;
import gr.nbg.acmefood.api.service.OrderService;
import gr.nbg.acmefood.api.transfer.ApiResponse;
import gr.nbg.acmefood.api.transfer.resource.OrderResource;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController extends BaseController<Order, OrderResource> {

    private final OrderService orderService;
    private final OrderMapper orderMapper;

    @Override
    public BaseService<Order, Long> getBaseService() {
        return orderService;
    }

    @Override
    public BaseMapper<Order, OrderResource> getMapper() {
        return orderMapper;
    }

    @GetMapping(params = "serial")
    public ResponseEntity<ApiResponse<OrderResource>> findById(@RequestParam Long id) {
        final OrderResource orderResource = getMapper().toResource(orderService.get(id));
        return ResponseEntity.ok(ApiResponse.<OrderResource>builder().data(orderResource).build());
    }
}
