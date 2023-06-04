import React from "react";
import CustomNavbar from "./CustomNavbar";
import Sidebar from "./Sidebar";
import CustomFooter from "./CustomFooter";
import WrapperComponent from "./Layouts/WrapperComponent";
import ContentWrapperComponent from "./Layouts/ContentWrapperComponent";
import ContentComponent from "./Layouts/ContentComponent";

const Base = ({ title = "Welcome to Pictu", children }) => {
	return (
		<div>
			<WrapperComponent>
				<Sidebar />
				<ContentWrapperComponent>
					<ContentComponent>
						<CustomNavbar />
						{children}
					</ContentComponent>
				</ContentWrapperComponent>
			</WrapperComponent>
			<CustomFooter />
		</div>
	);
};
export default Base;
