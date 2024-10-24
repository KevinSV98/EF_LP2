package pe.com.cibertec.EF_LP2.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import pe.com.cibertec.EF_LP2.model.entity.ProductoEntity;
import pe.com.cibertec.EF_LP2.repository.ProductoRepository;
import pe.com.cibertec.EF_LP2.service.ProductoService;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements ProductoService {
	
    private final ProductoRepository productoRepository;
    
    ProductoServiceImpl(ProductoRepository ProductoServiceImpl) {
        this.productoRepository = ProductoServiceImpl;
    }

    @Override
    public List<ProductoEntity> buscarTodosProductos() {
        return productoRepository.findAll();
    }


    @Override
    public ProductoEntity buscarProductoPorId(Integer id) {
        return productoRepository.findById(id).get();
    }
}
