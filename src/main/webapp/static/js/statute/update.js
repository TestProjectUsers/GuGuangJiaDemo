let vm = new Vue({
    el:"#main-container",
    data:{
        statute:'',
        myConfig: {
            // 如果需要上传功能,找后端小伙伴要服务器接口地址
            // serverUrl: 'http://localhost:8090/ueditor/ueditorConfig',
            // 你的UEditor资源存放的路径  path是全局声明的应用路径
            //'/static/ueditor/'是应用下存放ueditor文件位置注意最后一个"/"不能省略
            UEDITOR_HOME_URL: 'static/ueditor/',
            // 编辑器不自动被内容撑高
            autoHeightEnabled: false,
            // 工具栏是否可以浮动
            autoFloatEnabled: false,
            // 初始容器高度
            initialFrameHeight: 340,
            // 初始容器宽度
            initialFrameWidth: '100%',
            // 关闭自动保存
            enableAutoSave: true,
            // 上传文件接口（
            serverUrl: 'http://localhost:8080/GuGuangJiaDemo/controller'
        },
    },
    methods:{
        update:function () {
            axios({
                url:"manager/statute/update",
                method:"post",
                data: this.statute
            }).then(response =>{
                console.log(response.data)
                parent.layer.msg(response.data)
                let index = parent.layer.getFrameIndex(window.name);
                parent.layer.close(index);
            }).catch()
        }
    },components: {
        VueUeditorWrap
    },
    created:function () {
        this.statute = parent.layer.statute
    }
})