import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchPropostaComponent } from './search-proposta.component';

describe('SearchPropostaComponent', () => {
  let component: SearchPropostaComponent;
  let fixture: ComponentFixture<SearchPropostaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SearchPropostaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchPropostaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
