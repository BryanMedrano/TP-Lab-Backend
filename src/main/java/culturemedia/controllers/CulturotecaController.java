package culturemedia.controllers;

import java.util.*;

import culturemedia.exception.VideoNotFoundException;
import culturemedia.model.Video;
import culturemedia.service.CulturotecaService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("videos")
@CrossOrigin(origins = "*")
public class CulturotecaController {

	private final CulturotecaService culturotecaService;

	public CulturotecaController(CulturotecaService culturotecaService) {
		this.culturotecaService = culturotecaService;
	}

	@GetMapping
	public List<Video> findAllVideos() throws VideoNotFoundException {
		List<Video> videos = culturotecaService.findAll();
		if (videos.isEmpty()){
			throw new VideoNotFoundException();
		}
		return videos;
	}

	@PostMapping
	public Video save(@RequestBody Video save){
		return culturotecaService.save(save);
	}
}

