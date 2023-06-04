import React from "react";
import {
	Container,
	Navbar,
	NavbarToggler,
	Collapse,
	Nav,
	NavItem,
	NavLink,
	InputGroup,
	Input,
	Button,
	UncontrolledDropdown,
	DropdownToggle,
	DropdownMenu,
	DropdownItem,
	Form,
} from "reactstrap";

export default function CustomNavbarRS() {
	return (
		<div id="content-wrapper" className="d-flex flex-column">
			{/* Main Content */}
			<div id="content">
				{/* Topbar */}
				<Navbar color="light" light className="topbar mb-4 static-top shadow">
					{/* Sidebar Toggle (Topbar) */}
					<NavbarToggler />
					{/* Topbar Search */}
					<Form className="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
						<InputGroup>
							<Input
								type="text"
								className="form-control bg-light border-0 small"
								placeholder="Search for..."
								aria-label="Search"
								aria-describedby="basic-addon2"
							/>
							<Input addonType="append">
								<Button color="primary">
									<i className="fas fa-search fa-sm" />
								</Button>
							</Input>
						</InputGroup>
					</Form>
					{/* Topbar Navbar */}
					<Collapse navbar>
						<Nav className="ml-auto" navbar>
							{/* Nav Item - Search Dropdown (Visible Only XS) */}
							<NavItem className="nav-item dropdown no-arrow d-sm-none">
								<NavLink
									className="nav-link dropdown-toggle"
									href="#"
									id="searchDropdown"
									role="button"
									data-toggle="dropdown"
									aria-haspopup="true"
									aria-expanded="false"
								>
									<i className="fas fa-search fa-fw" />
								</NavLink>
								{/* Dropdown - Messages */}
								<DropdownMenu
									className="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in"
									aria-labelledby="searchDropdown"
								>
									<Form className="form-inline mr-auto w-100 navbar-search">
										<InputGroup>
											<Input
												type="text"
												className="form-control bg-light border-0 small"
												placeholder="Search for..."
												aria-label="Search"
												aria-describedby="basic-addon2"
											/>
											<Input addonType="append">
												<Button color="primary">
													<i className="fas fa-search fa-sm" />
												</Button>
											</Input>
										</InputGroup>
									</Form>
								</DropdownMenu>
							</NavItem>
							{/* Nav Item - Alerts */}
							<NavItem className="nav-item dropdown no-arrow mx-1">
								<NavLink
									className="nav-link dropdown-toggle"
									href="#"
									id="alertsDropdown"
									role="button"
									data-toggle="dropdown"
									aria-haspopup="true"
									aria-expanded="false"
								>
									<i className="fas fa-bell fa-fw" />
									{/* Counter - Alerts */}
									<span className="badge badge-danger badge-counter">3+</span>
								</NavLink>
								{/* Dropdown - Alerts */}
								<DropdownMenu
									className="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in"
									aria-labelledby="alertsDropdown"
								>
									<h6 className="dropdown-header">Alerts Center</h6>
									<DropdownItem href="#">
										<div className="d-flex align-items-center">
											<div className="mr-3">
												<div className="icon-circle bg-primary">
													<i className="fas fa-file-alt text-white" />
												</div>
											</div>
											<div>
												<div className="small text-gray-500">
													December 12, 2019
												</div>
												<span className="font-weight-bold">
													A new monthly report is ready to download!
												</span>
											</div>
										</div>
									</DropdownItem>
									<DropdownItem href="#">
										<div className="d-flex align-items-center">
											<div className="mr-3">
												<div className="icon-circle bg-success">
													<i className="fas fa-donate text-white" />
												</div>
											</div>
											<div>
												<div className="small text-gray-500">
													December 7, 2019
												</div>
												$290.29 has been deposited into your account!
											</div>
										</div>
									</DropdownItem>
									<DropdownItem href="#">
										<div className="d-flex align-items-center">
											<div className="mr-3">
												<div className="icon-circle bg-warning">
													<i className="fas fa-exclamation-triangle text-white" />
												</div>
											</div>
											<div>
												<div className="small text-gray-500">
													December 2, 2019
												</div>
												Spending Alert: We've noticed unusually high spending
												for your account.
											</div>
										</div>
									</DropdownItem>
									<DropdownItem
										href="#"
										className="text-center small text-gray-500"
									>
										Show All Alerts
									</DropdownItem>
								</DropdownMenu>
							</NavItem>
							{/* Nav Item - Messages */}
							<NavItem className="nav-item dropdown no-arrow mx-1">
								<NavLink
									className="nav-link dropdown-toggle"
									href="#"
									id="messagesDropdown"
									role="button"
									data-toggle="dropdown"
									aria-haspopup="true"
									aria-expanded="false"
								>
									<i className="fas fa-envelope fa-fw" />
									{/* Counter - Messages */}
									<span className="badge badge-danger badge-counter">7</span>
								</NavLink>
								{/* Dropdown - Messages */}
								<DropdownMenu
									className="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in"
									aria-labelledby="messagesDropdown"
								>
									<h6 className="dropdown-header">Message Center</h6>
									<DropdownItem href="#">
										<div className="d-flex align-items-center">
											<div className="dropdown-list-image mr-3">
												<img
													className="rounded-circle"
													src="img/undraw_profile_1.svg"
													alt="..."
												/>
												<div className="status-indicator bg-success" />
											</div>
											<div className="font-weight-bold">
												<div className="text-truncate">
													Hi there! I am wondering if you can help me with a
													problem I've been having.
												</div>
												<div className="small text-gray-500">
													Emily Fowler · 58m
												</div>
											</div>
										</div>
									</DropdownItem>
									<DropdownItem href="#">
										<div className="d-flex align-items-center">
											<div className="dropdown-list-image mr-3">
												<img
													className="rounded-circle"
													src="img/undraw_profile_2.svg"
													alt="..."
												/>
												<div className="status-indicator" />
											</div>
											<div>
												<div className="text-truncate">
													I have the photos that you ordered last month, how
													would you like them sent to you?
												</div>
												<div className="small text-gray-500">Jae Chun · 1d</div>
											</div>
										</div>
									</DropdownItem>
									<DropdownItem href="#">
										<div className="d-flex align-items-center">
											<div className="dropdown-list-image mr-3">
												<img
													className="rounded-circle"
													src="img/undraw_profile_3.svg"
													alt="..."
												/>
												<div className="status-indicator bg-warning" />
											</div>
											<div>
												<div className="text-truncate">
													Last month's report looks great, I am very happy with
													the progress so far, keep up the good work!
												</div>
												<div className="small text-gray-500">
													Morgan Alvarez · 2d
												</div>
											</div>
										</div>
									</DropdownItem>
									<DropdownItem href="#">
										<div className="d-flex align-items-center">
											<div className="dropdown-list-image mr-3">
												<img
													className="rounded-circle"
													src="https://source.unsplash.com/Mv9hjnEUHR4/60x60"
													alt="..."
												/>
												<div className="status-indicator bg-success" />
											</div>
											<div>
												<div className="text-truncate">
													Am I a good boy? The reason I ask is because someone
													told me that people say this to all dogs, even if they
													aren't good...
												</div>
												<div className="small text-gray-500">
													Chicken the Dog · 2w
												</div>
											</div>
										</div>
									</DropdownItem>
									<DropdownItem
										href="#"
										className="text-center small text-gray-500"
									>
										Read More Messages
									</DropdownItem>
								</DropdownMenu>
							</NavItem>
							<div className="topbar-divider d-none d-sm-block" />
							{/* Nav Item - User Information */}
							<NavItem className="nav-item dropdown no-arrow">
								<NavLink
									className="nav-link dropdown-toggle"
									href="#"
									id="userDropdown"
									role="button"
									data-toggle="dropdown"
									aria-haspopup="true"
									aria-expanded="false"
								>
									<span className="mr-2 d-none d-lg-inline text-gray-600 small">
										Douglas McGee
									</span>
									<img
										className="img-profile rounded-circle"
										src="img/undraw_profile.svg"
									/>
								</NavLink>
								{/* Dropdown - User Information */}
								<DropdownMenu
									className="dropdown-menu dropdown-menu-right shadow animated--grow-in"
									aria-labelledby="userDropdown"
								>
									<DropdownItem href="#">
										<i className="fas fa-user fa-sm fa-fw mr-2 text-gray-400" />
										Profile
									</DropdownItem>
									<DropdownItem href="#">
										<i className="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400" />
										Settings
									</DropdownItem>
									<DropdownItem href="#">
										<i className="fas fa-list fa-sm fa-fw mr-2 text-gray-400" />
										Activity Log
									</DropdownItem>
									<div className="dropdown-divider" />
									<DropdownItem
										href="#"
										data-toggle="modal"
										data-target="#logoutModal"
									>
										<i className="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400" />
										Logout
									</DropdownItem>
								</DropdownMenu>
							</NavItem>
						</Nav>
					</Collapse>
				</Navbar>
			</div>
			{/* End of Topbar */}
		</div>
	);
}
