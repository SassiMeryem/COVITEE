import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';

import { ICommande, Commande } from 'app/shared/model/commande.model';
import { CommandeService } from './commande.service';
import { IVehicule } from 'app/shared/model/vehicule.model';
import { VehiculeService } from 'app/entities/vehicule/vehicule.service';
import { IPosition } from 'app/shared/model/position.model';
import { PositionService } from 'app/entities/position/position.service';

type SelectableEntity = IVehicule | IPosition;

@Component({
  selector: 'jhi-commande-update',
  templateUrl: './commande-update.component.html'
})
export class CommandeUpdateComponent implements OnInit {
  isSaving = false;
  vehicules: IVehicule[] = [];
  positions: IPosition[] = [];
  dateDp: any;

  editForm = this.fb.group({
    id: [],
    date: [],
    prix: [null, [Validators.required]],
    type: [null, [Validators.required]],
    typeservice: [null, [Validators.required]],
    vehicule: [],
    position: []
  });

  constructor(
    protected commandeService: CommandeService,
    protected vehiculeService: VehiculeService,
    protected positionService: PositionService,
    protected activatedRoute: ActivatedRoute,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ commande }) => {
      this.updateForm(commande);

      this.vehiculeService.query().subscribe((res: HttpResponse<IVehicule[]>) => (this.vehicules = res.body || []));

      this.positionService.query().subscribe((res: HttpResponse<IPosition[]>) => (this.positions = res.body || []));
    });
  }

  updateForm(commande: ICommande): void {
    this.editForm.patchValue({
      id: commande.id,
      date: commande.date,
      prix: commande.prix,
      type: commande.type,
      typeservice: commande.typeservice,
      vehicule: commande.vehicule,
      position: commande.position
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const commande = this.createFromForm();
    if (commande.id !== undefined) {
      this.subscribeToSaveResponse(this.commandeService.update(commande));
    } else {
      this.subscribeToSaveResponse(this.commandeService.create(commande));
    }
  }

  private createFromForm(): ICommande {
    return {
      ...new Commande(),
      id: this.editForm.get(['id'])!.value,
      date: this.editForm.get(['date'])!.value,
      prix: this.editForm.get(['prix'])!.value,
      type: this.editForm.get(['type'])!.value,
      typeservice: this.editForm.get(['typeservice'])!.value,
      vehicule: this.editForm.get(['vehicule'])!.value,
      position: this.editForm.get(['position'])!.value
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<ICommande>>): void {
    result.subscribe(
      () => this.onSaveSuccess(),
      () => this.onSaveError()
    );
  }

  protected onSaveSuccess(): void {
    this.isSaving = false;
    this.previousState();
  }

  protected onSaveError(): void {
    this.isSaving = false;
  }

  trackById(index: number, item: SelectableEntity): any {
    return item.id;
  }
}
