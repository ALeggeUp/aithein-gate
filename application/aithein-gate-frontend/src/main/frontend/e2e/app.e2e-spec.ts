import { AitheinGatePage } from './app.po';

describe('aithein-gate App', () => {
  let page: AitheinGatePage;

  beforeEach(() => {
    page = new AitheinGatePage();
  });

  it('should display welcome message', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('Welcome to app!');
  });
});
