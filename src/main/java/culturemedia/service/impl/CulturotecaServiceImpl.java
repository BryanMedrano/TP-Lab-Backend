package culturemedia.service.impl;

import culturemedia.exception.VideoNotFoundException;
import culturemedia.model.Video;
import culturemedia.model.View;
import culturemedia.repository.VideoRepository;
import culturemedia.repository.ViewsRepository;
import culturemedia.service.CulturotecaService;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CulturotecaServiceImpl implements CulturotecaService {

    private final VideoRepository videoRepository;
    private final ViewsRepository viewsRepository;

    public CulturotecaServiceImpl(VideoRepository videoRepository, ViewsRepository viewsRepository) {
        this.videoRepository = videoRepository;
        this.viewsRepository = viewsRepository;
    }

    @Override
    public List<Video> findAll() throws VideoNotFoundException {
        List<Video> videos = videoRepository.findAll();
        if (videos.isEmpty()){
            throw new VideoNotFoundException();
        }
        return videos;
    }

    @Override
    public Video save(Video save) {
        return videoRepository.save(save);
    }

    @Override
    public View add(View add) {
        return viewsRepository.add(add);
    }

    @Override
    public List<Video> findByTitle(String title) throws VideoNotFoundException {
        List<Video> filteredVideos = new ArrayList<>();
        for (Video video : videoRepository.findAll()) {
            if (video.title().toLowerCase().contains(title.toLowerCase())) {
                filteredVideos.add(video);
            }
        }
        if (filteredVideos.isEmpty()) {
            throw new VideoNotFoundException(title);
        }
        return filteredVideos;
    }

    @Override
    public List<Video> findByDuration(Double fromDuration, Double toDuration) throws VideoNotFoundException {
        List<Video> filteredVideos = new ArrayList<>();
        for (Video video : videoRepository.findAll()) {
            if (video.duration() >= fromDuration && video.duration() <= toDuration) {
                filteredVideos.add(video);
            }
        }
        if (filteredVideos.isEmpty()) {
            throw new VideoNotFoundException();
        }
        return filteredVideos;
    }
}
