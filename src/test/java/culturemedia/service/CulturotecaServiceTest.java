package culturemedia.service;

import culturemedia.exception.VideoNotFoundException;
import culturemedia.model.Video;
import culturemedia.repository.VideoRepository;
import culturemedia.repository.ViewsRepository;
import culturemedia.repository.impl.VideoRepositoryImpl;
import culturemedia.repository.impl.ViewsRepositoryImpl;
import culturemedia.service.impl.CulturotecaServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;


class CulturotecaServiceTest {

    private CulturotecaService culturotecaService;
    @Mock
    private VideoRepository videoRepository;
    @Mock
    private ViewsRepository viewsRepository;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        culturotecaService = new CulturotecaServiceImpl(videoRepository,viewsRepository);
    }

    @Test
    void when_FindAll_does_not_find_any_video_an_VideoNotFoundException_should_be_thrown_successfully()  {
        mockFindAllDoesNotFind();
        culturotecaService = new CulturotecaServiceImpl( new VideoRepositoryImpl(), new ViewsRepositoryImpl());
        assertThrows(VideoNotFoundException.class, () -> culturotecaService.findAll());
    }

    @Test
    void when_FindAll_all_videos_should_be_returned_successfully() throws VideoNotFoundException{
        mockFindAllReturnsVideos();
        List<Video> videos = culturotecaService.findAll();
        assertEquals(6, videos.size());
    }

    @Test
    void when_FindByTitle_videos_with_the_title_should_be_returned_successfully() throws VideoNotFoundException {
        mockFindByTitleReturnsVideos();
        List<Video> videos = culturotecaService.findByTitle("Clic");
        assertEquals(2, videos.size());
        assertEquals("Clic 5", videos.get(0).title());
        assertEquals("Clic 6", videos.get(1).title());
    }

    @Test
    void when_FindByTitle_does_not_find_any_video_an_VideoNotFoundException_should_be_thrown_successfully() {
        mockFindByTitleDoesNotFind("Laboratory");
        VideoNotFoundException exception = assertThrows(VideoNotFoundException.class, () -> culturotecaService.findByTitle("Laboratory"));
        assertEquals("Video not found by title: Laboratory", exception.getMessage());
    }

    @Test
    void when_FindByDuration_videos_in_the_duration_range_should_be_returned_successfully() throws VideoNotFoundException {
        mockFindByDurationReturnsVideos();
        List<Video> videos = culturotecaService.findByDuration(4.5, 5.5);
        assertEquals(3, videos.size());
    }

    @Test
    void when_FindByDuration_does_not_find_any_video_an_VideoNotFoundException_should_be_thrown_successfully() {
        mockFindByDurationDoesNotFind();
        VideoNotFoundException exception = assertThrows(VideoNotFoundException.class, () -> culturotecaService.findByDuration(1.0, 2.0));
        assertEquals("Video not found.", exception.getMessage());
    }

    private void mockFindAllReturnsVideos(){
        doReturn(List.of(new Video("01", "Título 1", "Descripción 1", 4.5),
                new Video("02", "Título 2", "Descripción 2", 5.5),
                new Video("03", "Título 3", "Descripción 3", 4.4),
                new Video("04", "Título 4", "Descripción 4", 3.5),
                new Video("05", "Clic 5", "Descripción 5", 5.7),
                new Video("06", "Clic 6", "Descripción 6", 5.1))
        ).when(videoRepository).findAll();
    }

    private void mockFindAllDoesNotFind() {
        doReturn(List.of()).when(videoRepository).findAll();
    }

    private void mockFindByTitleReturnsVideos() {
        doReturn(List.of(
                new Video("05", "Clic 5", "Descripción 5", 5.7),
                new Video("06", "Clic 6", "Descripción 6", 5.1)
        )).when(videoRepository).findAll();
    }

    private void mockFindByTitleDoesNotFind(String title) {
        doReturn(List.of()).when(videoRepository).find(title);
    }

    private void mockFindByDurationReturnsVideos() {
        doReturn(List.of(
                new Video("01", "Título 1", "Descripción 1", 4.5),
                new Video("02", "Título 2", "Descripción 2", 5.5),
                new Video("06", "Clic 6", "Descripción 3", 5.1)
        )).when(videoRepository).findAll();
    }

    private void mockFindByDurationDoesNotFind() {
        doReturn(List.of()).when(videoRepository).find(1.0, 2.0);
    }
}