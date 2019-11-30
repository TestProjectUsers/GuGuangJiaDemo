let vm = new Vue({
    el: "#main-container",
    data: {
        pageInfo: {
            pageNum: 1,
            pageSize: 3
        },
        appVersion:{}
    }, methods: {
        selectAll: function (pageNum, pageSize) {
            axios({
                url: "manager/app/selectAll",
                params: {
                    pageNum: pageNum,
                    pageSize: pageSize
                }
            }).then(response => {
                // console.log(response.data)
                this.pageInfo = response.data;
            }).catch(function (error) {
                console.log(error)
            })
        },
        toUpdate: function (id) {
            axios({
                url: "manager/app/toUpdate",
                params: {id: id}
            }).then(response => {
                layer.appVersion = response.data;
                console.log(layer)
                console.log(layer.appVersion)
                let index = layer.open({
                    type: 2,
                    title: '更新数据',
                    content: 'html/app/save.html',
                    area: ['80%', '80%'],
                    end: () => {
                        this.selectAll(this.pageInfo.pageNum, this.pageInfo.pageSize)
                    }
                });
            }).catch(function (error) {
                console.log(error)
            })
        },
        deleteMsg: function (id) {
            layer.msg("是否删除", {
                time: 0,
                btn: ['是', '否'],
                yes: index => {
                    axios({
                        url: "manager/app/deleteMsg",
                        params: {id: id}
                    }).then(response => {
                        layer.close(index)
                        layer.msg(response.data.msg)
                        if (response.data.success){
                            this.selectAll(this.pageInfo.pageNum, this.pageInfo.pageSize)
                        }
                    })
                }
            })

        },
        insertMsg:function () {
            axios({
                url: "manager/app/insertMsg",
                method: "post",
                data: this.appVersion
            }).then(response => {
                console.log(response.data)
                if (response.data.success){
                    this.selectAll(this.pageInfo.pageNum, this.pageInfo.pageSize)
                    this.appVersion={}
                }
            }).catch(function (error) {
                console.log(error)
            })
        }
    },
    created: function () {
        this.selectAll();
    }
});