package com.fhce.inv.service;

import java.util.List;
import com.fhce.inv.obj.atencionRequestDTO;
import com.fhce.inv.obj.atencionResponseDTO;

public interface atencionService {
    atencionResponseDTO crearAtencion(atencionRequestDTO request);
    atencionResponseDTO actualizarAtencion(Long idAtencion, atencionRequestDTO request);
    atencionResponseDTO getAtencion(Long idAtencion);
    
    List<atencionResponseDTO> getAtencionesPorSolicitud(Long idSolicitud);
    List<atencionResponseDTO> getAtencionesPorEquipo(Long idEquipo);
    List<atencionResponseDTO> getAtencionesPorCif(Long cif);
    List<atencionResponseDTO> getTodasLasAtenciones();
}
