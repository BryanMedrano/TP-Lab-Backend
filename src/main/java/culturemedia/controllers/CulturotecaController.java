package culturemedia.controllers;

import java.util.*;

import culturemedia.exception.VideoNotFoundException;
import culturemedia.model.Video;
import culturemedia.service.CulturotecaService;

public class CulturotecaController {

	private final CulturotecaService culturotecaService;

	public CulturotecaController(CulturotecaService culturotecaService) {
		this.culturotecaService = culturotecaService;
	}

	public List<Video> findAllVideos() throws VideoNotFoundException {
		List<Video> videos = culturotecaService.findAll();
		if (videos.isEmpty()){
			throw new VideoNotFoundException();
		}
		return videos;
	}

	public Video save(Video save){
		return culturotecaService.save(save);
	}
}

