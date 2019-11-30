let vm = new Vue({
    el:"#main-container",
    data:{
        obj:{

        }
    },methods:{
        update: function (check) {
            this.obj.check = check;
            axios({
                url: "manager/sysarea/upDateMsg",
                method: "post",
                data: this.obj
            }).then(response => {

                console.log(response.data)
                parent.layer.msg(response.data.msg)
                let index = parent.layer.getFrameIndex(window.name);
                parent.layer.close(index);
            }).catch(function (error) {
                console.log(error)
            })
        },selectIcon:function(){
            console.log(layer)
            layer.icon = '';
            let index = layer.open({
                type:2,
                title:'区域修改',
                content:'html/modules/font-awesome.html',
                area:['80%','80%'],
                end: () => {//将then函数中的this传递到end的回调函数中
                    console.log(this.obj)
                    this.obj.icon = layer.icon;//将替换掉的icon值给vue
                }
            });
        }
    },created: function () {
        this.obj = parent.layer.obj;
    }
})