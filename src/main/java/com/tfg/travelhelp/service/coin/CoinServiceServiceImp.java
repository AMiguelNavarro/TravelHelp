package com.tfg.travelhelp.service.coin;

import com.tfg.travelhelp.domain.Coin;
import com.tfg.travelhelp.exceptions.CoinNotFoundException;
import com.tfg.travelhelp.repository.ICoinRepository;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoinServiceServiceImp implements ICoinService{

    @Autowired
    private ICoinRepository coinRepository;

    @Override
    public List<Coin> finAllCoins() {
        return coinRepository.findAll();
    }

    @Override
    public Coin findCoinFromCountry(long idCountry) {
        return coinRepository.findCoinFromCountry(idCountry);
    }

    @Override
    public Coin addNewCoin(Coin coin) {
        return coinRepository.save(coin);
    }

    @Override
    public Coin modifyCoin(long idCoin, Coin newCoin) {
        val coin = coinRepository.findById(idCoin)
                .orElseThrow(() -> new CoinNotFoundException(idCoin));
        newCoin.setId(coin.getId());
        return coinRepository.save(newCoin);
    }

    @Override
    public void deleteCoin(long idCoin) {
        val coin = coinRepository.findById(idCoin)
                .orElseThrow(() -> new CoinNotFoundException(idCoin));
        coinRepository.delete(coin);
    }
}
