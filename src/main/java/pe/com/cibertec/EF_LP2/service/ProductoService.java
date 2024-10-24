package pe.com.cibertec.EF_LP2.service;

import java.util.List;

import pe.com.cibertec.EF_LP2.model.entity.ProductoEntity;

public interface ProductoService {
    List<ProductoEntity> buscarTodosProductos();
    ProductoEntity buscarProductoPorId(Integer id);
    void crearProducto(ProductoEntity productoEntity);
    void actualizarProducto(Integer id, ProductoEntity productoEntity);
    void eliminarProducto(Integer id);
}
