package ua.itea.remoteCart.component.mapper.impl;

import ua.itea.remoteCart.component.mapper.ProductCartMapper;
import ua.itea.remoteCart.model.dto.CartProductDto;
import ua.itea.remoteCart.model.entity.CartProductEntity;

public class ProductCartMapperImpl implements ProductCartMapper{

	@Override
	public CartProductDto entityToDto(CartProductEntity entity) {
		return new CartProductDto().setId(entity.getId())
				.setQuantity(entity.getQuantity());
	}

	@Override
	public CartProductEntity dtoToEntity(CartProductDto dto) {
		 return new CartProductEntity().setId(dto.getId())
				 .setQuantity(dto.getQuantity());
	}

}
