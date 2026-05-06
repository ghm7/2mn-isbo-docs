# Text Content — Glossary

| Term | Definition | Related Terms |
|:-----|:-----------|:-------------|
| **create_assets/** | A path-like directory name that likely denotes a folder intended for creating, generating, or organizing project assets. | Directory Path, Asset Creation, Project Structure |
| **Directory** | A filesystem container used to group files and subdirectories under a shared location and purpose. | Folder, Path, Project Structure |
| **Trailing Slash** | The final '/' in a path, commonly used to indicate that the path refers to a directory rather than a file. | Directory, Path |
| **Snake Case** | A naming style where lowercase words are separated by underscores, as in 'create_assets'. | Naming Convention, Project Structure |
| **Asset** | A non-code or supporting project resource, such as an image, font, audio clip, template, icon, dataset, or media file. | Source Asset, Generated Asset |
| **Source Asset** | An original input file or editable resource used to create final or generated assets. | Asset, Generated Asset, Input |
| **Generated Asset** | An asset produced by a script, build process, export operation, or automated pipeline. | Asset, Output, Build Pipeline |
| **Intermediate Asset** | A temporary or transitional file created during asset processing but not intended as a final deliverable. | Generated Asset, Cache, Output |
| **Input** | A file, configuration, template, prompt, or parameter consumed by an asset-creation process. | Input/Output Contract, Source Asset |
| **Output** | A file or resource produced by an asset-creation process, often placed in a designated destination directory. | Generated Asset, Input/Output Contract |
| **Input/Output Contract** | A documented agreement specifying required inputs, expected outputs, file formats, naming rules, and destination paths. | Input, Output, Reproducibility |
| **README** | A documentation file that explains the purpose, usage, setup, commands, and conventions of a directory or project. | Directory-Level Documentation, Onboarding |
| **Directory-Level Documentation** | Documentation placed inside or near a folder to clarify what belongs there and how to use its contents. | README, Project Structure |
| **Build Pipeline** | An automated workflow that transforms source materials into final outputs through defined processing steps. | Automation, Generated Asset, Reproducibility |
| **Automation** | The use of scripts or tools to perform repeatable tasks without relying on undocumented manual actions. | Build Pipeline, Script, Reproducibility |
| **Script** | An executable file that performs a defined task, such as resizing images, generating icons, or validating assets. | Automation, Build Pipeline |
| **Reproducibility** | The property of a workflow that allows another person or system to recreate the same results from the same documented inputs and commands. | Dependency Pinning, Input/Output Contract, Build Pipeline |
| **Dependency Pinning** | The practice of fixing tool or library versions so asset-generation results remain stable across machines and time. | Reproducibility, Build Pipeline |
| **Version Control** | A system such as Git for tracking changes to files and coordinating collaboration over time. | Git, Version-Control Policy |
| **Version-Control Policy** | A rule set defining which source files, generated files, caches, and outputs should be committed or ignored. | Version Control, .gitignore, Generated Asset |
| **.gitignore** | A Git configuration file listing files or directories that should not be tracked in version control. | Git, Version-Control Policy |
| **Validation** | The process of checking assets against required rules such as format, dimensions, naming, file size, and completeness. | Quality Control, Asset Creation |
| **Placeholder Directory** | A directory included in a project structure before it has substantive contents, often to reserve an intended location. | .gitkeep, Project Structure |
| **.gitkeep** | A conventional empty file used to force Git to track an otherwise empty directory. | Placeholder Directory, Git |
