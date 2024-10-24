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

    @Override
    public List<ProductoEntity> buscarTodosProductos() {
        return productoRepository.findAll();
    }


    @Override
    public ProductoEntity buscarProductoPorId(Integer id) {
        return productoRepository.findById(id).get();
    }

    @Override
    public void crearProducto(ProductoEntity productoEntity) {
// TODO Auto-generated method stub
        productoRepository.save(productoEntity);
    }

    @Override
    public void actualizarProducto(Integer id, ProductoEntity productoNuevo) {
// TODO Auto-generated method stub
        ProductoEntity productoEncontrado = buscarProductoPorId(id);
        if(productoEncontrado == null) {
            throw new RuntimeException("Producto no encontrado");
        }

        try {
            productoEncontrado.setNombre(productoNuevo.getNombre());
            productoEncontrado.setPrecio(productoNuevo.getPrecio());
            productoEncontrado.setStock(productoNuevo.getStock());
            productoEncontrado.setCategoria(productoNuevo.getCategoria());
            productoRepository.save(productoEncontrado);
        } catch (Exception e) {
            throw new RuntimeException("Ocurrió un error al actualizar");
        }

    }

    @Override
    public void eliminarProducto(Integer id) {
        // TODO Auto-generated method stub
        ProductoEntity productoEncontrado = buscarProductoPorId(id);
        if(productoEncontrado != null) {
            productoRepository.delete(productoEncontrado);
        }
    }
}
