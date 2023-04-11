import { Layout, Dropdown, Menu, Button } from "antd";
import { UserOutlined } from "@ant-design/icons";
import React from "react";
import HomePage from "./components/HomePage";


const { Header, Content } = Layout;

const App = () => {

    return (
        <Layout style={{ height: "100vh" }}>
            <Header style={{ display: "flex", justifyContent: "space-between" }}>
                <div style={{ fontSize: 16, fontWeight: 600, color: "white" }}>
                    Facial Expression Recognition
                </div>
                <div>
                    <Dropdown trigger="click">
                        <Button icon={<UserOutlined />} shape="circle" />
                    </Dropdown>
                </div>
            </Header>
            <Content
                style={{ height: "calc(100% - 64px)", margin: 20, overflow: "auto" }}
            >
                <HomePage />
            </Content>
        </Layout>
    );

}

export default App;
