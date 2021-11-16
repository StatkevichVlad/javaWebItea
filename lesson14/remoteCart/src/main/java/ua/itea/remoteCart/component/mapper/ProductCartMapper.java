package ua.itea.remoteCart.component.mapper;

import org.springframework.stereotype.Component;
import ua.itea.remoteCart.model.dto.CartProductDto;
import ua.itea.remoteCart.model.entity.CartProductEntity;

@Component
public interface ProductCartMapper {
	CartProductDto entityToDto(CartProductEntity entity);

	CartProductEntity dtoToEntity(CartProductDto dto);
}
