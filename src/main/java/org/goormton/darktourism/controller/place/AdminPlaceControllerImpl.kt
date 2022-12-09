package org.goormton.darktourism.controller.place

import lombok.extern.slf4j.Slf4j
import org.goormton.darktourism.controller.place.dto.SimplePlaceDto
import org.goormton.darktourism.service.place.PlaceService
import org.goormton.darktourism.util.toOKResponseEntity
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@Slf4j
@RestController
class AdminPlaceControllerImpl(
    private val placeService: PlaceService,
) : AdminPlaceController {
    
    override fun allPlaceList(): ResponseEntity<*> {
        return placeService.findPlaceAll().map {
            simplePlaceDtoMapper.entityToDto(it, true)
        }.toResponseEntity()
    }
}