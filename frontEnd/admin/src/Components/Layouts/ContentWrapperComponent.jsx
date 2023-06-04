import React from "react";

const ContentWrapperComponent = ({ children }) => {
	return (
		<div id="content-wrapper" className="d-flex flex-column">
			{children}
		</div>
	);
};

export default ContentWrapperComponent;
