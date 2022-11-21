import { Page, withModel } from '@adobe/aem-react-editable-components';
import React from 'react';
import { Header } from './components/Header/Header';

// This component is the application entry point
class App extends Page {
  render() {
    return (
      <div>
        console.log("render");
        <Header />
        {this.childComponents}
        {this.childPages}
      </div>
    );
  }
}

export default withModel(App);
