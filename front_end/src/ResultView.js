import {  Descriptions  } from "antd";
import {  MinusCircleOutlined, PlusOutlined  } from "@ant-design/icons";
import React from 'react';




export function ResultView(props){

  return (
    <div>
  <Descriptions title="Preview Cost">
    <Descriptions.Item label="Employee ID">{props.emp.id}</Descriptions.Item>
    <Descriptions.Item label="Employee Name">{props.emp.name}</Descriptions.Item>
    <Descriptions.Item label="Yearly Deductions">${props.emp.employeeFinance.yearDeductions}</Descriptions.Item>
    <Descriptions.Item label="Paycheck Deduction">${props.emp.employeeFinance.paycheckDeduction}</Descriptions.Item>
    <Descriptions.Item label="Employee Recieves">${props.emp.employeeFinance.employeeRecieves}</Descriptions.Item>

  </Descriptions>
  </div>

  );

}

