package culturemedia.controllers;

import java.util.*;

import culturemedia.exception.VideoNotFoundException;
import culturemedia.model.Video;
import culturemedia.service.CulturotecaService;

public class CultureMediaController {

	private final CulturotecaService cultureMediaService;


	public CultureMediaController(CulturotecaService cultureMediaService) {
		this.cultureMediaService = cultureMediaService;
	}

	public List<Video> findAllVideos() throws VideoNotFoundException {

		List<Video> videos = cultureMediaService.findAll();
		if (videos.isEmpty()){
			throw new VideoNotFoundException();
		}
		return videos;
	}
	public Video save(Video save){
		return cultureMediaService.save(save);
	}
}

