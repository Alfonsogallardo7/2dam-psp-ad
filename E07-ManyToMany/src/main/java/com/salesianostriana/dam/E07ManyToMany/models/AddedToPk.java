package com.salesianostriana.dam.E07ManyToMany.models;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable @Builder
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class AddedToPk implements Serializable {

    private Long song_id;
    private Long playlist_id;
}
