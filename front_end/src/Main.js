
// import React, { Component } from "react";
// import 'antd/dist/antd.css'; // or 'antd/dist/antd.less'
// import  {  Form, Input, Button, Space, Select  } from 'antd';
// //import {  MinusCircleOutlined, PlusOutlined  } from  'icons';

// class Main extends Component {
//     constructor() {
//         super();
//         this.state = {
//           name: "",
//           dependentList: [],
//           errors: {}
//         };
    
//         // this.onChange = this.onChange.bind(this);
//         // this.onSubmit = this.onSubmit.bind(this);
//       }

//       render() {
//         const [form] = Form.useForm();

//         const onFinish = values => {
//           console.log('Received values of form:', values);
//         };
      
//         const handleChange = () => {
//           form.setFieldsValue({ sights: [] });
//         };

//         const { errors } = this.state;
//         const types = 
//         ["children",
//             "spouse"]
//           ;


        
//         const { Option } = Select;
            
        
//         // return (

//         //  <div>
//         //      <form>
//         //         <input type = "text"></input>
//         //         <div id="dependent">
                    
//         //         </div>
//         //         <button>Add dependent</button>
//         //         <input type = "submit"></input>

//         //      </form>
             
//         //  </div>
//         // );
//         return (
//             <Form form={form} name="dynamic_form_nest_item" onFinish={onFinish} autoComplete="off">
//               <Form.Item name="area" label="Area" rules={[{ required: true, message: 'Missing area' }]}>
//                 <Select options={areas} onChange={handleChange} />
//               </Form.Item>
//               <Form.List name="sights">
//                 {(fields, { add, remove }) => (
//                   <>
//                     {fields.map(field => (
//                       <Space key={field.key} align="baseline">
//                         <Form.Item
//                           noStyle
//                           shouldUpdate={(prevValues, curValues) =>
//                             prevValues.area !== curValues.area || prevValues.sights !== curValues.sights
//                           }
//                         >
//                           {() => (
//                             <Form.Item
//                               {...field}
//                               label="Type"
//                               name={[field.name, 'type']}
//                               fieldKey={[field.fieldKey, 'type']}
//                               rules={[{ required: true, message: 'Missing type' }]}
//                             >
//                               <Select style={{ width: 130 }}>
//                                 {types.map(item => (
//                                   <Option key={item} value={item}>
//                                     {item}
//                                   </Option>
//                                 ))}
//                               </Select>
//                             </Form.Item>
//                           )}
//                         </Form.Item>
//                         <Form.Item
//                           {...field}
//                           label="Name"
//                           name={[field.name, 'name']}
//                           fieldKey={[field.fieldKey, 'name']}
//                           rules={[{ required: true, message: 'Missing name' }]}
//                         >
//                           <Input />
//                         </Form.Item>
        
//                         <MinusCircleOutlined onClick={() => remove(field.name)} />
//                       </Space>
//                     ))}
        
//                     <Form.Item>
//                       <Button type="dashed" onClick={() => add()} block icon={<PlusOutlined />}>
//                         Add sights
//                       </Button>
//                     </Form.Item>
//                   </>
//                 )}
//               </Form.List>
//               <Form.Item>
//                 <Button type="primary" htmlType="submit">
//                   Submit
//                 </Button>
//               </Form.Item>
//             </Form>
//           );
//         };
//       }
    

// export default Main;