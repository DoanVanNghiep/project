package vn.com.web.service.Web.Managermaterial.Service;

import vn.com.web.service.Web.Managermaterial.Dto.CartDto;

import java.util.Collection;

public interface CartService {
    void add(CartDto cartItem);

    CartDto edit(int proID, int qTy);

    void delete(int id);

    int getCount();

    Double TotalPrice();

    Collection<CartDto> getAll();

    void clear();

    double getAmount();
}
