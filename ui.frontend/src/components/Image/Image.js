import React, { Component } from 'react';
import { MapTo } from '@adobe/aem-react-editable-components';

export const ImageEditConfig = {

    emptyLabel: 'Image',

    isEmpty: function (props) {
        return !props || !props.src || props.src.trim().length < 1;
    }
};
export const imgsrc = {
    margin: '1rem 0',
    width: '100%',
    border: '0'
}
class Image extends Component {


    get content() {
        return <img className={{ imgsrc }}
            src={this.props.src}
            alt={this.props.alt}
            title={this.props.title ? this.props.title : this.props.alt} />;
    }

    render() {
        if (ImageEditConfig.isEmpty(this.props)) {
            return null;
        }

        return (
            <div className="Image">
                {this.content}
            </div>
        );
    }
}
export default MapTo('wknd-spa-react/components/image')(Image, ImageEditConfig);

