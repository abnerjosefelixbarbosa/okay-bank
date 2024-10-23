import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ContaPoupancaComponent } from './conta-poupanca.component';

describe('ContaPoupancaComponent', () => {
  let component: ContaPoupancaComponent;
  let fixture: ComponentFixture<ContaPoupancaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ContaPoupancaComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ContaPoupancaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
