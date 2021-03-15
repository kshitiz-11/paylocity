import axios from 'axios';
import 'antd/dist/antd.css'
import {  Form, Input, Button, Space, Select  } from "antd";
import {  MinusCircleOutlined, PlusOutlined  } from "@ant-design/icons";
import React, { useState, useEffect} from 'react';
import {ResultView} from './ResultView';

const { Option } = Select;

const types =["children", "spouse"]

export const PreviewCost = () => {
  const [form] = Form.useForm();
  const [count, setCount] = useState(0);
  const [result, setResult] = useState({});
  const [temp, setTemp] = useState('');
  const onFinish = (values) => {
    console.log('Received values of form:', values);
    addEmployee(values);

  };

  const helper = () => {
    setTemp('');
  } 

  const addEmployee = async (emp) => {
    try {
       let res = await axios.post(`http://localhost:8080/employee/`, emp)
       let newobj= res.data;
       setResult(newobj);
       setCount(1);
       console.log('newobj', newobj);
      // console.log('success', res);
      
    } catch (error) {
        console.log('error', error);
    }
  };

  return (
    
    <Form form={form} name="dynamic_form_nest_item" onFinish={onFinish} autoComplete="off">
      
      <Form.Item name="name" label="Employee Name" rules={[{ required: true, message: 'Missing area' }]}>
      <Input />
      </Form.Item>
      <Form.List name="dependentList">
        {(fields, { add, remove }) => (
          <>
            {fields.map(field => (
              <Space key={field.key} align="baseline">
                <Form.Item
                  noStyle
                  shouldUpdate={(prevValues, curValues) =>
                    prevValues.area !== curValues.area || prevValues.sights !== curValues.sights
                  }
                >
                  {() => (
                    <Form.Item
                      {...field}
                      label="type"
                      name={[field.name, 'dependentType']}
                      fieldKey={[field.fieldKey, 'type']}
                      rules={[{ required: true, message: 'Missing type' }]}
                    >
                      <Select  style={{ width: 130 }}>
                        {types.map(item => (
                          <Option key={item} value={item}>
                            {item}
                          </Option>
                        ))}
                      </Select>
                    </Form.Item>
                  )}
                </Form.Item>
                <Form.Item
                  {...field}
                  label="Name"
                  name={[field.name, 'name']}
                  fieldKey={[field.fieldKey, 'name']}
                  rules={[{ required: true, message: 'Missing name' }]}
                >
                  <Input />
                </Form.Item>

                <MinusCircleOutlined onClick={() => remove(field.name)} />
              </Space>
            ))}

            <Form.Item>
              <Button type="dashed" onClick={() => add()} block icon={<PlusOutlined />}>
                Add Dependent
              </Button>
            </Form.Item>


          </>

          
        )}
      </Form.List>
      <Form.Item>
        <Button type="primary"  htmlType="submit">
          Submit
        </Button>
      </Form.Item>

    

      {
count ==0 ? <p></p> : <ResultView emp={result}></ResultView>
          }


    </Form>
  );
};

