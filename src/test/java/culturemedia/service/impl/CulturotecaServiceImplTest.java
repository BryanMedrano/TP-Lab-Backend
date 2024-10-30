package culturemedia.service.impl;

import culturemedia.exception.VideoNotFoundException;
import culturemedia.model.Video;
import culturemedia.repository.impl.VideoRepositoryImpl;
import culturemedia.repository.impl.ViewsRepositoryImpl;
import culturemedia.service.CulturotecaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CulturotecaServiceImplTest {

    private CulturotecaService culturotecaService;
    @BeforeEach
    void init() {
        culturotecaService = new CulturotecaServiceImpl(new VideoRepositoryImpl(), new ViewsRepositoryImpl());
        List<Video> videos = List.of(
                new Video("01", "Título 1", "Descripción 1", 4.5),
                new Video("02", "Título 2", "Descripción 2", 5.5),
                new Video("03", "Título 3", "Descripción 3", 4.4),
                new Video("04", "Título 4", "Descripción 4", 3.5),
                new Video("05", "Clic 5", "Descripción 5", 5.7),
                new Video("06", "Clic 6", "Descripción 6", 5.1)
        );

        for (Video video : videos) {
            culturotecaService.save(video);
        }
    }

    @Test
    void when_FindAll_does_not_find_any_video_an_VideoNotFoundException_should_be_thrown_successfully()  {
        culturotecaService = new CulturotecaServiceImpl( new VideoRepositoryImpl(), new ViewsRepositoryImpl());
        VideoNotFoundException exception = assertThrows(VideoNotFoundException.class, () -> culturotecaService.findAll());
    }

    @Test
    void when_FindAll_all_videos_should_be_returned_successfully() throws VideoNotFoundException{
        List<Video> videos = culturotecaService.findAll();
        assertEquals(6, videos.size());
    }

    @Test
    void when_FindByTitle_videos_with_the_title_should_be_returned_successfully() throws VideoNotFoundException {
        List<Video> videos = culturotecaService.findByTitle("Clic");
        assertEquals(2, videos.size());
        assertEquals("Clic 5", videos.get(0).title());
        assertEquals("Clic 6", videos.get(1).title());
    }

    @Test
    void when_FindByTitle_does_not_find_any_video_an_VideoNotFoundException_should_be_thrown_successfully() {
        VideoNotFoundException exception = assertThrows(VideoNotFoundException.class, () -> culturotecaService.findByTitle("Laboratory"));
        assertEquals("Video not found by title: Laboratory", exception.getMessage());
    }

    @Test
    void when_FindByDuration_videos_in_the_duration_range_should_be_returned_successfully() throws VideoNotFoundException {
        List<Video> videos = culturotecaService.findByDuration(4.5, 5.5);
        assertEquals(3, videos.size());
        assertEquals("Título 1", videos.get(0).title());
        assertEquals("Título 2", videos.get(1).title());
        assertEquals("Clic 6", videos.get(2).title());
    }

    @Test
    void when_FindByDuration_does_not_find_any_video_an_VideoNotFoundException_should_be_thrown_successfully() {
        VideoNotFoundException exception = assertThrows(VideoNotFoundException.class, () -> culturotecaService.findByDuration(1.0, 2.0));
        assertEquals("Video not found.", exception.getMessage());
    }

}