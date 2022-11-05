package com.ironhack.RPG.Services;

import com.ironhack.RPG.Model.Character;

/*Un servicio que se encarga de printal lo que pasa durante la batalla - no contiene la logica... se ira llamando
* desde la clase que lleve la logica de la batalla*/

public class DuelLog {

    /*prints the current status of the party -> llamaremos des del menu*/
    public void showParty(int partyReferenceNum){
        Party showParty = getPartyByRefNum(partyReferenceNum);


    }

    /*Prints the chosen characters for this battle*/
    public void chosenCharacters(Character fighter1, Character fighter2){
        System.out.println(fighter1.toString());
    }


}
