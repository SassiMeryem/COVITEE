import { ICommande } from 'app/shared/model/commande.model';
import { Typevehicule } from 'app/shared/model/enumerations/typevehicule.model';

export interface IVehicule {
  id?: number;
  matricule?: string;
  type?: Typevehicule;
  capacite?: number;
  commandes?: ICommande[];
}

export class Vehicule implements IVehicule {
  constructor(
    public id?: number,
    public matricule?: string,
    public type?: Typevehicule,
    public capacite?: number,
    public commandes?: ICommande[]
  ) {}
}
