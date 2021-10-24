package com.salesianostriana.dam.E06Ejercicio2;

import com.salesianostriana.dam.E06Ejercicio2.model.CursoOnline;
import com.salesianostriana.dam.E06Ejercicio2.model.Profesor;
import com.salesianostriana.dam.E06Ejercicio2.model.Video;
import com.salesianostriana.dam.E06Ejercicio2.services.CursoOnlineService;
import com.salesianostriana.dam.E06Ejercicio2.services.ProfesorService;
import com.salesianostriana.dam.E06Ejercicio2.services.VideoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@AllArgsConstructor
public class MainPrueba {

    private final CursoOnlineService cursoOnlineService;
    private final ProfesorService profesorService;
    private final VideoService videoService;

    @PostConstruct
    public void tests (){
        Profesor p1 = Profesor.builder()
                .nombre("Miguel Campos")
                .email("miguelcampos@salesianos.edu")
                .puntuacion(4.5)
                .build();

        profesorService.save(p1);

        CursoOnline c1 = CursoOnline.builder()
                .nombre("Curso de Android Online")
                .puntuacion(4.6)
                .build();

        cursoOnlineService.save(c1);
        c1.addProfesor(p1);
        cursoOnlineService.edit(c1);

        Video v1 = Video.builder()
                .orden("1")
                .titulo("Introducción a Android")
                .descripcion("Aprende a programar en Android y" +
                        " Java para crear aplicaciones móviles desde cero de manera profesional. ")
                .url("https://openwebinars.net/academia/aprende/android/2808/")
                .build();

        videoService.save(v1);

        c1.addVideo(v1);
        cursoOnlineService.edit(c1);


        System.out.println("El curso que hemos añadido se llama " + c1.getNombre() + ", lo imparte " + c1.getProfesor().getNombre()
                + "y el video que hemos añadido es: " + c1.getVideos().get(0).getUrl() );

    }
}
