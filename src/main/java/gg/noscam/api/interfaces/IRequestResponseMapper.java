package gg.noscam.api.interfaces;

public interface IRequestResponseMapper <E, REQ, RES> {

    E toEntity(REQ dto);

    RES toDTO(E entity);

}
