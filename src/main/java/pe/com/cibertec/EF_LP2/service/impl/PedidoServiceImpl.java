package pe.com.cibertec.EF_LP2.service.impl;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import pe.com.cibertec.EF_LP2.model.entity.PedidoEntity;
import pe.com.cibertec.EF_LP2.repository.PedidoRepository;

@Service
@RequiredArgsConstructor
public class PedidoServiceImpl {
	
	private final PedidoRepository pedidoRepository;
	
	@Override
	public void crearPedido(PedidoEntity pedidoEntity) {
		// TODO Auto-generated method stub
		pedidoRepository.save(pedidoEntity);
		
	}
}
