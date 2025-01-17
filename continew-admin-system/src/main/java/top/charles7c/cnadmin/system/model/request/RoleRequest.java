/*
 * Copyright (c) 2022-present Charles7c Authors. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package top.charles7c.cnadmin.system.model.request;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import org.hibernate.validator.constraints.Length;

import top.charles7c.cnadmin.common.base.BaseRequest;
import top.charles7c.cnadmin.common.enums.DataScopeEnum;
import top.charles7c.cnadmin.common.enums.DisEnableStatusEnum;

/**
 * 创建或修改角色信息
 *
 * @author Charles7c
 * @since 2023/2/8 23:12
 */
@Data
@Schema(description = "创建或修改角色信息")
public class RoleRequest extends BaseRequest {

    private static final long serialVersionUID = 1L;

    /**
     * 角色 ID
     */
    @Schema(description = "角色 ID")
    @Null(message = "新增时，ID 必须为空", groups = Create.class)
    @NotNull(message = "修改时，ID 不能为空", groups = Update.class)
    private Long roleId;

    /**
     * 角色名称
     */
    @Schema(description = "角色名称")
    @NotBlank(message = "角色名称不能为空")
    private String roleName;

    /**
     * 角色编码
     */
    @Schema(description = "角色编码")
    private String roleCode;

    /**
     * 数据权限（1全部数据权限 2本部门及以下数据权限 3本部门数据权限 4仅本人数据权限 5自定义数据权限）
     */
    @Schema(description = "数据权限（1全部数据权限 2本部门及以下数据权限 3本部门数据权限 4仅本人数据权限 5自定义数据权限）", type = "Integer",
        allowableValues = {"1", "2", "3", "4", "5"})
    private DataScopeEnum dataScope;

    /**
     * 数据权限范围（部门 ID 数组）
     */
    @Schema(description = "数据权限范围（部门 ID 数组）")
    private List<Long> dataScopeDeptIds;

    /**
     * 描述
     */
    @Schema(description = "描述")
    @Length(max = 200, message = "描述长度不能超过 200 个字符")
    private String description;

    /**
     * 角色排序
     */
    @Schema(description = "角色排序")
    @NotNull(message = "角色排序不能为空")
    private Integer roleSort;

    /**
     * 状态（1启用 2禁用）
     */
    @Schema(description = "状态（1启用 2禁用）", type = "Integer", allowableValues = {"1", "2"})
    private DisEnableStatusEnum status;
}
