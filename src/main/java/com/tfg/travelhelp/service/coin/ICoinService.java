package com.tfg.travelhelp.service.coin;

import com.tfg.travelhelp.domain.Coin;
import com.tfg.travelhelp.domain.EmergencyPhone;

import java.util.List;

public interface ICoinService {
    List<Coin> finAllCoins();
    Coin findCoinFromCountry(long idCountry);
    Coin addNewCoin(Coin coin);
    Coin modifyCoin(long idCoin, Coin newCoin);
    void deleteCoin(long idCoin);
}
