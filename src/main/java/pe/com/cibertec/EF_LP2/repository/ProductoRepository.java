package pe.com.cibertec.EF_LP2.repository;

	import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.stereotype.Repository;

import pe.com.cibertec.EF_LP2.model.entity.ProductoEntity;
	

	@Repository
	public interface ProductoRepository extends JpaRepository<ProductoEntity, Integer> {

		
	}

