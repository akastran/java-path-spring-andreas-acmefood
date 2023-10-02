package gr.nbg.acmefood.api.controller;

import gr.nbg.acmefood.api.domain.Store;
import gr.nbg.acmefood.api.mapper.BaseMapper;
import gr.nbg.acmefood.api.mapper.StoreMapper;
import gr.nbg.acmefood.api.service.BaseService;
import gr.nbg.acmefood.api.service.StoreService;
import gr.nbg.acmefood.api.transfer.ApiResponse;
import gr.nbg.acmefood.api.transfer.resource.StoreResource;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreController extends BaseController<Store, StoreResource> {

    private final StoreService storeService;
    private final StoreMapper storeMapper;

    @Override
    public BaseService<Store, Long> getBaseService() {
        return storeService;
    }

    @Override
    public BaseMapper<Store, StoreResource> getMapper() {
        return storeMapper;
    }

    @GetMapping(params = "serial")
    public ResponseEntity<ApiResponse<StoreResource>> findById(@RequestParam Long id) {
        final StoreResource storeResource = getMapper().toResource(storeService.get(id));
        return ResponseEntity.ok(ApiResponse.<StoreResource>builder().data(storeResource).build());
    }
}
