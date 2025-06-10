package com.fhce.inv.service;

import java.util.List;
import com.fhce.inv.obj.solicitudAtencionRequestDTO;
import com.fhce.inv.obj.solicitudAtencionResponseDTO;
import com.fhce.inv.obj.solicitudAtencionCompletaDTO;

public interface solicitudService {
    solicitudAtencionResponseDTO crearSolicitud(solicitudAtencionRequestDTO request);
    solicitudAtencionResponseDTO actualizarSolicitud(Long idSolicitud, solicitudAtencionRequestDTO request);
    solicitudAtencionCompletaDTO getSolicitudCompleta(Long idSolicitud);

    List<solicitudAtencionCompletaDTO> getSolicitudesEnEspera();
    List<solicitudAtencionCompletaDTO> getSolicitudesAtendidas();
    List<solicitudAtencionCompletaDTO> getSolicitudesPorEquipo(Long idEquipo);
    List<solicitudAtencionCompletaDTO> getSolicitudesPorCif(Long cif);
    List<solicitudAtencionCompletaDTO> getTodasLasSolicitudes();
    
}