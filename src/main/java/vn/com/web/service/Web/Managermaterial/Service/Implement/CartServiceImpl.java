package vn.com.web.service.Web.Managermaterial.Service.Implement;

import org.springframework.stereotype.Service;
import vn.com.web.service.Web.Managermaterial.Dto.CartDto;
import vn.com.web.service.Web.Managermaterial.Service.CartService;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class CartServiceImpl implements CartService {
    Map<Integer,CartDto > maps = new HashMap<>();
    @Override
    public void add(CartDto cartItem) {
        CartDto cartDto = maps.get(cartItem.getProduct().getId());
        if (cartDto == null){
            maps.put(cartItem.getProduct().getId(), cartItem);
        }else
            cartDto.setQty(cartDto.getQty());
    }

    @Override
    public CartDto edit(int proID, int qTy) {
        CartDto cartDto = maps.get(proID);
        cartDto.setQty(qTy);
        return cartDto;
    }

    @Override
    public void delete(int id) {
        maps.remove(id);
    }

    @Override
    public int getCount() {
        return maps.values().size();
    }

    @Override
    public Double TotalPrice() {
        return maps.values().stream()
                .mapToDouble(item -> item.getQty()* item.getTotalPrice())
                .sum();
    }

    @Override
    public Collection<CartDto> getAll() {
        return maps.values();
    }

    @Override
    public void clear() {
        maps.clear();
    }

    @Override
    public double getAmount(){
        return maps.values().stream().mapToDouble(item -> item.getQty() * item.getTotalPrice()).sum();
    }
}
