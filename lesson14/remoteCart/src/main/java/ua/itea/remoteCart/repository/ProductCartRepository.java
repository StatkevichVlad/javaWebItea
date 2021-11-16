package ua.itea.remoteCart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.itea.remoteCart.model.entity.CartProductEntity;

@Repository
public interface ProductCartRepository extends JpaRepository<CartProductEntity, Integer> {

}
